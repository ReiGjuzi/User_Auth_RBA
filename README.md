# User_Auth_RBA

Role based authentication and authorization demo using Java Swing and a file-backed user store. This README expands the explanations to cover every class, method, and key block of logic so you can follow the full flow end to end.

## Overview
This project implements a small desktop application with:
- A login screen that accepts a username and a 4-digit code.
- Admin and employee flows (admin can manage users, employees see limited tabs).
- Role based permissions with read and write access levels.
- File persistence in `users.txt` using a simple CSV-style format.
- A 3-strike lockout that requires admin unlock.

The UI is Swing-based and the storage is a plain text file for quick inspection and manual edits.

## How to run
- Open the project in IntelliJ.
- Run `app.AppMain`.
- On first run, an admin user is seeded.
  - Username: `admin`
  - Code: `1000`

## Authentication flow (end-to-end)
1) The login UI collects username and 4-digit code.
2) The store looks up the user by username in `users.txt`.
3) If the user is locked, login fails immediately.
4) The code is hashed (SHA-256) and compared to the stored hash.
5) A successful login resets failed attempts and routes:
   - Admins to the admin panel.
   - Everyone else to the employee panel.
6) A failed login increments failed attempts; after 3, the account is locked.

Unlocking:
- Admins can edit the user and set a new code, which clears lock and failed attempts.
- If the admin account is locked, edit `users.txt` directly (set failedAttempts to 0 and locked to false).

## Data storage (users.txt)
File: `users.txt` in the project root.

Each line is a comma-separated record:
1) username
2) password hash (SHA-256)
3) role name (enum name, uppercase)
4) firstName
5) lastName
6) age
7) gender
8) salary
9) permissions string (8 chars; order matches Permission enum, codes N/R/W/B)
10) failedAttempts (integer)
11) locked (true/false)

If a line only has 3 fields, it is treated as a minimal user record (username, hash, role) with default permissions for that role.

## Permissions model
Access levels in `security.AccessLevel`:
- `NONE` (N): no access
- `READ` (R): view only
- `WRITE` (W): modify
- `READ_WRITE` (B): read and write

Permissions in `security.Permission` (order matters for storage):
1) CREATE_ORDER
2) EDIT_ORDER
3) CONFIRM_PURCHASE
4) DELETE_PURCHASE
5) EDIT_SHOW_NAME
6) EDIT_SHOW_INFO
7) ADD_SHOW
8) DELETE_SHOW

Role defaults in `security.UserPermissions.forRole`:
- ADMIN, MANAGER: READ_WRITE for all permissions.
- BOX_OFFICE, USER: READ_WRITE for order permissions; NONE for show permissions.
- SALES: READ_WRITE for create/edit/confirm; NONE for delete and show.
- USHER: READ for create/edit; NONE for the rest.
- SHOW_MANAGER: READ_WRITE for show permissions; NONE for order permissions.
- CUSTOM: starts with NONE and is set in the UI.

Permission enforcement rules:
- UI tabs are enabled only if the user has READ for a related permission group.
- Action buttons and input fields are enabled only if the user has WRITE for the specific permission.
- WRITE implies READ in `security.Authorization`.

## Code walkthrough (class by class, method by method)

### `src/app/AppMain.java`
- `main`: app entry point.
  - Creates a `UserStoreFile`.
  - Calls `seedAdmin()` to ensure an admin exists the first time.
  - Opens the login screen with the store so UI can authenticate.

### `src/model/Role.java`
- Enum values: each role has a display name and a 1-digit code prefix used when generating 4-digit codes.
- `getDisplayName`, `getCodePrefix`: simple getters for UI display and code validation.
- `isAdmin`: returns true for the ADMIN role (used to route to admin UI).
- `fromDisplayName`: tries to map a UI name (case-insensitive) to a role; falls back to `fromStoredName`.
- `fromStoredName`: maps stored role strings to enum values; unknown names become `CUSTOM`.
- `selectableRoles`: returns roles that should appear in the role dropdown.

### `src/model/User.java`
- Stores user profile data plus security state.
- Constructors:
  - Minimal constructor assigns defaults and permissions by role.
  - Full constructors accept profile fields, permissions, failed attempts, and lock status.
  - Null permissions are replaced with defaults from the role.
- Getter methods: expose fields to UI and store.
- Setter methods:
  - `setRole` updates the role and reuses default permissions if none exist.
  - `setFailedAttempts` prevents negative values.
  - `setLocked` toggles lock state.

### `src/model/UserStoreFile.java`
- Fields:
  - `USERS_FILE`: file handle for `users.txt`.
  - `MAX_FAILED_ATTEMPTS`: threshold for locking accounts (3).
- `exists(username)`: true if `get(username)` finds a record.
- `authenticate(username, code)`:
  - Returns null on missing user, locked user, or invalid code.
  - Uses `PasswordUtil.matches` to compare input code with stored hash.
- `get(username)`:
  - Scans the file line by line.
  - Parses each line into a `User`.
  - Returns the first matching username or null.
- `seedAdmin()`:
  - Creates an `admin` account with code `1000` only if it does not exist.
  - Hashes the code via `PasswordUtil.hash`.
- `add(user)`:
  - Appends a CSV line to `users.txt`.
  - Uses `safe` to avoid null values.
  - Writes failedAttempts and locked state too.
- `update(username, updatedUser)`:
  - Loads all users, replaces the matching one, then rewrites the file.
  - Returns false if no match is found.
- `delete(username)`:
  - Loads all users, removes the matching one, rewrites the file.
  - Returns false if no match is found.
- `getAll()`:
  - Reads all lines and stores them in a map keyed by username.
  - The map ensures uniqueness and returns values as a collection.
- `findByCode(code)`:
  - Hashes the code and scans for a user with a matching hash.
  - Returns that user or null.
- `codeExists(code)`:
  - Convenience check that delegates to `findByCode`.
- `codeInUseByOther(code, username)`:
  - True if the code hash matches some user and the username does not match.
  - Used for edit validation to avoid code collisions.
- `recordFailedLogin(username)`:
  - Increments failedAttempts for the user.
  - Locks the account at 3 attempts.
  - Writes the updated list back to disk.
  - Returns whether the account is now locked.
- `resetLoginFailures(username)`:
  - Sets failedAttempts to 0 and locked to false for the user.
  - Writes the updated list back to disk.
- `parseLine(line)`:
  - Splits CSV into fields.
  - Builds a `User` with defaults where fields are missing.
  - Parses permissions, failedAttempts, and locked state.
- `loadAll()`:
  - Reads the entire file into a list of `User` objects.
- `writeAll(users)`:
  - Overwrites the file with current user records.
  - Returns true if write succeeds, false on error.
- `safe(value)`:
  - Converts null to an empty string to avoid `null` text in the file.

### `src/security/AccessLevel.java`
- Enum values represent permission intensity.
- `getCode`: returns the storage code for the access level.
- `fromCode`: maps the stored char to an access level, defaulting to NONE.

### `src/security/Permission.java`
- Enum listing the 8 permissions.
- Order matters because compact storage uses this sequence.

### `src/security/UserPermissions.java`
- Fields hold access levels per permission.
- Constructor stores the eight levels.
- `forRole(role)`:
  - Maps each role to a set of access levels.
  - CUSTOM defaults to no access.
- `none()`: returns all NONE levels.
- `full()`: returns all READ_WRITE levels.
- `fromCompactString(value)`:
  - Converts 8 chars into the 8 AccessLevel values.
  - Short or null strings become NONE everywhere.
- `toCompactString()`:
  - Serializes the 8 permissions into an 8-char string for `users.txt`.
- Getter methods: expose each permission to UI and authorization checks.

### `src/security/Authorization.java`
- Utility class, not instantiable.
- `can(user, permission, required)`:
  - Returns false for null users.
  - Delegates to `can(permissions, permission, required)`.
- `can(permissions, permission, required)`:
  - Looks up the access level and checks if it satisfies the required level.
- `hasAnyAccess(user, permission)` and `hasAnyAccess(permissions, permission)`:
  - Checks if access is not NONE.
- `getLevel(permissions, permission)`:
  - Switches on permission and returns the correct level.
- `allows(level, required)`:
  - Enforces WRITE implies READ and handles READ_WRITE as full access.

### `src/security/PasswordUtil.java`
- `hash(password)`:
  - Uses SHA-256 to hash a code or password string.
  - Returns a lowercase hex string.
- `matches(password, hashed)`:
  - Returns false if either input is null.
  - Hashes the plain input and compares to the stored hash.

### `src/UI/Login_page.java`
- Fields hold UI components and a `UserStoreFile` reference.
- Constructor:
  - Builds the Swing login form with labels, inputs, and a submit button.
  - Uses a black background with white text.
  - Wires the submit button to validation and authentication.
- Submit button flow:
  - Validates username presence.
  - Validates code presence and 4-digit format.
  - Fetches the user from the store.
  - Rejects locked accounts with a clear message.
  - If the code hash does not match, records a failed login.
  - On success, resets failures and routes to admin or employee page.
  - Hides the login window after opening the next screen.

### `src/UI/Admin_page.java`
- Fields include the store and a parent frame for back navigation.
- Constructor:
  - Builds admin menu buttons for add, edit, delete user.
  - Adds a back button to return to login.
- Button actions:
  - Add User -> opens `New_user` in create mode.
  - Edit User -> opens `Edit_user`.
  - Delete User -> opens `Delete_user`.
  - Back -> shows login and closes admin window.

### `src/UI/New_user.java`
- Handles both create and edit flows.
- Fields:
  - UI inputs for name, surname, age, gender, role, salary, code.
  - Permission checkboxes arranged in rows (Read, Write, None).
  - `editing` flag and `currentUser` for edit mode.
  - `adjustingPermissions` guard to avoid recursive checkbox changes.
  - `SecureRandom` to generate unique codes.
- Constructors:
  - `New_user(store, parent)` starts in create mode.
  - `New_user(store, parent, user)` starts in edit mode and populates fields.
- UI setup:
  - A scrollable form with labels, inputs, and permission rows.
  - A small button generates a new code based on role prefix.
- Permission rows:
  - Each row has Read/Write/None checkboxes.
  - `PermissionRow` wraps the three related checkboxes for easy handling.
- `bindRow(row)`:
  - Ensures selecting None clears Read/Write.
  - Keeps row state consistent and prevents re-entry via `adjustingPermissions`.
- `applyRoleSelection(role)`:
  - If CUSTOM, enables manual permission editing.
  - Otherwise, applies role defaults and disables manual edits.
- `setPermissionRowsEnabled(enabled)` and `setRowEnabled(row, enabled)`:
  - Enable or disable the checkboxes when role is not CUSTOM.
- `setPermissionsOnRows(permissions)`:
  - Sets each row to match the given permission levels.
- `readPermissionsFromRows()`:
  - Converts the current row selections into a `UserPermissions` instance.
- `setRowLevel(row, level)` and `getRowLevel(row)`:
  - Synchronize AccessLevel values to checkbox states and vice versa.
- `syncRowSelection(row)`:
  - Keeps "None" checked when both Read and Write are unchecked.
- `generateCode(role)`:
  - Uses role prefix + random 3-digit suffix.
  - Tries up to 1000 times to avoid duplicates, then falls back to a random code.
- `buildRoleDisplayNames()`:
  - Builds dropdown options from `selectableRoles`.
  - If editing a user with a non-standard role, adds it so it remains selectable.
- Save button flow:
  - Validates required fields and 4-digit code format.
  - Checks username and code uniqueness in the store.
  - Enforces code prefix that matches the selected role.
  - Hashes the code if provided; preserves existing hash when editing with no new code.
  - Uses role defaults or CUSTOM selections for permissions.
  - Preserves lock state on edit unless a new code is set (then resets).
  - Calls `store.update` or `store.add`, then clears or updates UI feedback.
- Back button flow:
  - Returns to parent (admin or edit screen) and closes this window.

### `src/UI/Edit_user.java`
- UI for selecting a user and opening the edit form.
- Constructor:
  - Builds a dropdown of usernames and edit/back buttons.
  - Calls `refreshUsers()` initially.
- `setVisible(visible)`:
  - Refreshes the user list each time the screen is shown.
- `refreshUsers()`:
  - Loads all users, collects usernames, sorts them, and fills the combo box.
  - Updates status text when no users exist.
- Edit button flow:
  - Loads the selected user.
  - Opens `New_user` in edit mode and hides this window.
- Back button flow:
  - Returns to parent and closes this window.

### `src/UI/Delete_user.java`
- UI for selecting a user and deleting them.
- Constructor:
  - Builds a dropdown, delete/back buttons, and status label.
  - Calls `refreshUsers()` initially.
- `setVisible(visible)`:
  - Refreshes the user list when the screen is shown.
- `refreshUsers()`:
  - Loads and sorts usernames; updates the combo box.
  - Shows "No users found" when empty.
- Delete button flow:
  - Confirms via dialog.
  - Calls `store.delete` and updates status text accordingly.
- Back button flow:
  - Returns to parent and closes this window.

### `src/UI/Employee_page.java`
- Employee-facing UI with tabs: New Ticket, Orders, Changes.
- Fields hold controls and action buttons for each tab.
- Constructor:
  - Builds the tabbed UI and logout button.
  - Calls `applyPermissions` to enable or disable UI based on permissions.
  - Adds button handlers that call `requirePermission` before actions.
- `applyPermissions(permissions)`:
  - Enables the New Ticket tab if CREATE_ORDER has READ.
  - Enables input fields and Save button only if CREATE_ORDER has WRITE.
  - Enables the Orders tab if any order-related permission has READ.
  - Enables order edit and confirm/delete buttons based on WRITE checks.
  - Enables the Changes tab if any show-related permission has READ.
- `setTabEnabled(panel, enabled)`:
  - Enables or disables a tab by index.
- `buildDisplayName(user)`:
  - Uses first + last name when available, otherwise falls back to username.
- `requirePermission(permission, required)`:
  - Checks authorization and shows a dialog if not allowed.
  - Returns true when the action is permitted.

## UI screens (quick map)
- `UI.Login_page`: login, lockout, and routing to admin/employee screens.
- `UI.Admin_page`: admin menu for user management.
- `UI.New_user`: create/edit user, code generation, custom permissions.
- `UI.Edit_user`: selects a user to edit.
- `UI.Delete_user`: deletes a user with confirmation.
- `UI.Employee_page`: tabs gated by permissions; no order persistence.
