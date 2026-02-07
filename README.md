# User_Auth_RBA

Role based authentication and authorization demo using Java Swing and a file-backed user store.

## Overview
This project implements a small desktop application with:
- A login screen with a 4-digit code.
- Admin and employee flows.
- Role based permissions with read and write access levels.
- File persistence in `users.txt`.
- A 3-strike lockout that requires admin unlock.

The UI is Swing-based and the storage is a simple CSV-style file for easy inspection.

## How to run
- Open the project in IntelliJ.
- Run `app.AppMain`.
- On first run, an admin user is seeded.
  - Username: `admin`
  - Code: `1000`

## Authentication flow
1) User enters username and 4-digit code.
2) The code is hashed (SHA-256) and matched against `users.txt`.
3) After 3 wrong attempts, the account is locked.
4) Locked users see: "Account locked. Contact admin to unlock the account."

Unlocking:
- Admin can edit the user and set a new code (this clears lock and failed attempts).
- If the admin account is locked, unlock by editing `users.txt` directly.

## Roles, permissions, and access levels
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

Permission enforcement:
- UI tabs are enabled only if the user has READ.
- Action buttons and input fields are enabled only if the user has WRITE.
- WRITE implies READ in `security.Authorization`.

## UI screens
`UI.Login_page`
- Collects username and code.
- Enforces 3-strike lockout.
- Routes admins to the admin panel and everyone else to the employee panel.

`UI.Admin_page`
- Entry point for admin actions.
- Opens the create, edit, and delete user screens.

`UI.New_user`
- Create or edit a user.
- Generates a 4-digit code using the role prefix.
- For CUSTOM roles, enables permission checkboxes (Read/Write/None).
- When editing, preserves lock state unless a new code is set.

`UI.Edit_user`
- Select a user and open `New_user` for editing.

`UI.Delete_user`
- Select and delete a user after confirmation.

`UI.Employee_page`
- Tabs: New Ticket, Orders, Changes.
- Tabs are enabled only with READ access.
- Buttons and fields are enabled only with WRITE access.
- This is UI-only; no order persistence is implemented.

## Data storage
File: `users.txt` in the project root.

Each line is a comma-separated record:
1) username
2) password hash (SHA-256)
3) role name
4) firstName
5) lastName
6) age
7) gender
8) salary
9) permissions string (8 chars, order above, codes N/R/W/B)
10) failedAttempts (integer)
11) locked (true/false)

Older records with fewer fields are supported and default to no lock and 0 failed attempts.

## Code map (class by class)
`src/app/AppMain.java`
- App entry point.
- Seeds admin and opens the login screen.

`src/model/Role.java`
- Role definitions and display names.
- Role code prefix for 4-digit codes.
- Mapping from display name to role.

`src/model/User.java`
- User domain model with profile fields.
- Stores permissions, failedAttempts, and lock state.

`src/model/UserStore.java`
- In-memory user store (not used by the main app).

`src/model/UserStoreFile.java`
- File-backed store for users.
- Create, update, delete, and lookup.
- Parses and writes `users.txt`.
- Implements lockout tracking.

`src/security/AccessLevel.java`
- Read/write access levels and storage codes.

`src/security/Permission.java`
- Permission list used across the UI and storage.

`src/security/UserPermissions.java`
- Permission bundle per user.
- Role default mappings.
- Compact storage conversion.

`src/security/Authorization.java`
- Central permission checks.
- WRITE implies READ.

`src/security/PasswordUtil.java`
- SHA-256 hashing and match helper.

`src/UI/Login_page.java`
- Login screen and lockout enforcement.

`src/UI/Admin_page.java`
- Admin navigation screen.

`src/UI/New_user.java`
- Create/edit user form and permission editor.

`src/UI/Edit_user.java`
- User selection for editing.

`src/UI/Delete_user.java`
- User deletion flow.

`src/UI/Employee_page.java`
- Employee workflow tabs and permission gating.

`src/test/UserStoreSwingTest.java`
- Small Swing test for adding users to the file store.

## Known limitations
- File storage is plain text and not encrypted.
- Password hashing uses SHA-256 without salt.
- Orders and show updates are UI-only and not persisted.
- No concurrent file access handling.
