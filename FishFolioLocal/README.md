# Fishfolio

Fishfolio offers an innovative and efficient platform tailored for the operational management of multiple fish hatcheries. This full-stack solution is adept at facilitating comprehensive inventory management and providing detailed analytics on fish growth and health statistics over time. Crafted with Vue.js for front-end dynamism, Java for reliable back-end operations, and PostgreSQL for secure database management, Fishfolio is a testament to modern web application design. Hosted with care on Heroku and Netlify, the platform ensures high availability and performance.

Experience Fishfolio in action by visiting [Fishfolio](https://fishfolioapp.com)

## Project Architecture

The architecture of Fishfolio emphasizes a modular design, distinguishing clearly between the client and server components to streamline both development and deployment workflows. With a 'mobile-first' design ethos, the platform offers an optimized user experience on mobile devices, while also supporting a responsive full-screen mode for desktop viewing.

### Development Variants

Fishfolio is presented in two distinct code bases:

- **FishfolioLive**: The production-grade code that powers the live application.
- **FishFolioLocal**: The local development iteration designated to run on the localhost environment, facilitating testing and development without affecting the live system.

### Frontend
- **Framework**: Vue.js
- **Deployment**: Netlify
- **Responsive Design**: The UI is fully responsive, adapting to different screen sizes using Bootstrap for CSS.

### Backend
- **Language**: Java
- **Database**: PostgreSQL
- **Deployment**: Heroku
- **Repository**: [GitHub](https://github.com/MillsAdam/Fishfolio)

## Features

### Guest Features
- **Public Timeline**: Display of fish data with filter and sorting capabilities.
- **Individual Fish Detail Pages**: In-depth information about each fish.

### Admin Features
- **Secure Authentication**: Using JWT for secure login to the admin features.
- **CRUD Operations**: Ability to add, edit, and delete fish records.

## Backend Development

RESTful APIs enable the management of fish data, including:
- Fetching timeline data and individual fish details.
- Sorting functionality.
- Admin capabilities for managing fish records.

## Frontend Development

The frontend interacts with the backend through API calls, featuring:
- Dynamic data display of fish statistics.
- Authentication mechanisms for admin functions.

## User Roles and Permissions

Role-based access ensures:
- Admin users can access admin features and manage records (Forms).
- Guests have view-only access to public data (Info and Data).

## Data Tracking Over Time

Historical data tracking is achieved through:
- Unique identifiers for each fish entry.
- Separate storage for historical data or changes.

## Testing

No testing was done for this project.  In the future I would implement:
- Unit tests.
- Integration tests.
- User acceptance testing.

## Deployment

Deployment considerations:
- Use of Heroku for backend and database.
- Use of Netlify for frontend.
- Domain and SSL setup for security.

## Navigation Header Behavior

The navigation header of Fishfolio is dynamic and context-sensitive, providing different options based on the user's authentication status and role.

### For Non-Authenticated Users

- **Home**: Redirects to the login page as the user is not logged in.
- **Login**: Takes the user to the login form where they can enter their credentials.
- **Register**: Directs the user to a registration form to create a new account.

### For Authenticated Users (ROLE_USER)

Once logged in, the navigation header changes to reflect the actions available to a user:

- **Home**: Returns the user to the main dashboard of the platform.
- **Logout**: Logs the user out and redirects them to the login page.
- **Info**: Leads to an interactive page where detailed fish data can be browsed and examined.
- **Data**: Reveals a dropdown menu with two additional options:
    - **Inventory**: Opens an interactive page displaying a table of the current fish inventory.
    - **History**: Navigates to an interactive page where the user can view a table of historical data.

### Admin-Specific Navigation

For users with admin privileges, the navigation header includes an additional 'Forms' option with a dropdown menu:

- **Fish Form**: Allows the admin to add new fish records, update existing ones, or delete them. Changes made here will automatically synchronize with the 'History' section to maintain data consistency.
- **History Form**: Enables the admin to directly add, update, or delete entries in the history records. History records are used to track the inventory fish data over time.

By providing admins with intuitive forms and automated processes, Fishfolio ensures efficient and error-free management of the hatchery data.

### Technical Implementation

The navigation header is implemented using conditional rendering based on authentication state. This ensures that users only see options relevant to their current context, enhancing security and user experience.

- **State Management**: Utilizes Vue.js reactivity to update the navigation header based on user authentication status.
- **Routing**: Integrates with Vue Router to manage page redirections and protect private routes.
- **Security**: Ensures that attempts to navigate to protected pages without authentication are redirected to the login page.

## Info and Inventory Page Search Functionality

The Inventory page provides users with powerful search and sort capabilities to efficiently manage and view fish data:

### Sort By
- **Most Recent**: Displays the newest entries first.
- **Oldest**: Lists the entries starting with the earliest recorded.
- **Most Popular**: Sorts entries based on a popularity metric, such as the number of views or interactions.

### Fish ID
- **Specific Search**: Users can search for a fish by its unique identifier (Fish ID).

### Type
- **Dynamic Dropdown**: Contains all fish types currently in the database, loaded into state. Users can filter the inventory by selecting a specific type.

### Location
- **Dynamic Dropdown**: Includes all locations where fish have been recorded in the database, loaded into state. Users can search inventory by selecting a particular location.

## History Page Search Functionality

The History page allows users to delve into the past records of fish data with the following search options:

### History ID
- **Specific Search**: Enables search for historical entries using their unique History ID.

### Fish ID
- **Record Association**: When a Fish ID is searched, the system displays all historical data associated with that specific Fish ID.

### Date
- **Popup Calendar**: Provides a calendar interface for users to select a specific date. The search will return all historical entries for the selected month and year.

## Implementation Notes

- The search functionality should be implemented using stateful components that hold the current database entries for types and locations.
- Search options should dynamically update to reflect the current state of the database.
- Search results should be displayed promptly and be easy to navigate.

By integrating these search capabilities, Fishfolio allows users to access and analyze data with precision and ease, improving the overall efficiency of fish data management.

## Fish Form

Using the 'Fish Form', admins have the ability to create, update, and delete fish records. Each operation requires specific information to be entered:

#### Create a New Fish Record
- **Name**: Enter the name of the fish.
- **Type**: Enter the type of fish.
- **Length**: Input the length of the fish.
- **Weight**: Input the weight of the fish.
- **Location**: Indicate where the fish was caught.
- **Lure Used**: Optionally add the type of lure used (if applicable).
- **Date Caught**: Select the date when the fish was caught.
- **Image**: Optionally add an image of the fish via url image.

Upon submission, a unique Fish ID is automatically generated for the data provided.

#### Update an Existing Fish Record
- **Fish ID**: Provide the unique identifier of the fish to update.
- Plus all fields required for creating a new fish record.

#### Delete a Fish Record
- **Fish ID**: Enter the unique identifier of the fish to remove it from the database.

### Automated Synchronization with History Data

Any addition, update, or deletion of a fish record through the 'Fish Form' is automatically synchronized with the history data. This ensures that historical records reflect the most current data without requiring manual updates:

- **Add**: A new entry in the history is created whenever a fish is added.
- **Update**: Corresponding history data is updated when a fish record is modified.
- **Delete**: The fish's historical data is deleted alongside the inventory record.

## History Form

The History Form is a vital tool for admins to manage the chronicle of fish data over time. It provides the ability to create, update, and delete historical records associated with the fish inventory.

#### Creating a New History Record
- **Fish ID**: Input the unique identifier for the fish.
- **Date Caught**: Enter the date when the fish was caught.
- **Length**: Record the current length of the fish.
- **Weight**: Input the current weight of the fish.

Upon submission, a unique History ID is automatically generated for the new historical entry.

#### Updating an Existing History Record
- **History ID**: Provide the unique identifier for the historical entry.
- Plus all fields required for creating a new history record.

#### Deleting a History Record
- **History ID**: Enter the unique identifier of the history record to remove it from the database.

## Automated ID Generation and Data Integrity

- **ID Generation**: The system automatically assigns a unique Fish ID and History ID for each new record, ensuring easy tracking and referencing.
- **Data Consistency**: The form ensures all necessary data is present and correct before allowing updates or creation, maintaining the integrity of historical data.

## Technical Implementation

- **Form Handling**: Backend logic is set up to manage the creation, update, and deletion of inventory and historical records as per form submissions.
- **Data Validation**: Need to double check.  Checks are in place to ensure the accuracy and completeness of the data provided in the form.
- **Error Handling**: Need to double check.  The system provides clear feedback to the admin in case of any errors during form operations, with logging for technical follow-up if needed.

## Installation Instructions

To get Fishfolio up and running on your local environment, follow these detailed instructions. Ensure you have `npm` and `Java` installed on your machine before beginning the setup process.

### Database Setup

1. **Create the Database**:
    - Begin by creating a new database called `fishfolio` in your PostgreSQL instance.
    - Use the PostgreSQL command line or a GUI like pgAdmin to create the database.

2. **Initialize the Database**:
    - Navigate to the `database` directory within the Java application folder:
      ```sh
      cd Fishfolio/FishfolioLocal/java/database
      ```
    - Run the `create` script to set up the necessary tables and relations:
      ```sh
      ./create
      ```
    - Ensure that the script completes without errors to confirm that the database is set up correctly.

### Backend Setup

1. **Compile the Backend Application**:
    - Ensure that you are in the root directory of the Java application.
    - Compile the application using Maven.

2. **Run the Backend Server**:
    - Start the Java application.
    - Ensure it's connected to the `fishfolio` database correctly.
    - By default, the backend server runs on `http://localhost:9000`.

### Application Setup

1. **Install Dependencies**:
    - Change directory to the `vue` folder where the front-end application resides:
      ```sh
      cd Fishfolio/vue
      ```
    - Install all required npm packages:
      ```sh
      npm install
      ```
    - This command reads the `package.json` file and installs all the dependencies listed there.

2. **Run the Application**:
    - After successfully installing the dependencies, start the Vue.js application using:
      ```sh
      npm run serve
      ```
    - This will compile the front-end application and typically starts a local server.

3. **Accessing the Application**:
    - Once the server starts, you should see output indicating the local address to access the app, usually `http://localhost:8080`.
    - Open your web browser and navigate to that address to begin using Fishfolio.


### Final Steps

- Verify that both the front-end and back-end services are running and communicating with each other.

Congratulations, you've successfully set up Fishfolio on your local machine! For further configuration and usage, please refer to the user guides provided for admin and guest users.

## Roles

Fishfolio defines two primary user roles with different levels of access and permissions within the system. Below are the default credentials for each role, which you can use to log into the system initially.

### User (ROLE_USER)

- **Default Credentials**:
  - **Username**: user
  - **Password**: password

- **Description**:
  - This role is designed for general users who need to access public fish data.
  - Users with the ROLE_USER can view the public timeline, access individual fish detail pages, and utilize search and sort functionalities.
  - Newly registered users are automatically assigned the ROLE_USER.

### Admin (ROLE_ADMIN)

- **Default Credentials**:
  - **Username**: admin
  - **Password**: password

- **Description**:
  - The admin role has comprehensive access to the system.
  - Users with ROLE_ADMIN can add, update, and delete fish inventory and history records for in-depth data management.


# Final Thoughts

This project used small bits of starter code for login/register functionality from Tech Elevator Capstone (was recommended to use this approach from previous instructors). Although the current authentication system serves its purpose, I'm looking forward to enhancing security and user experience by integrating more robust authentication mechanisms, such as OAuth, in the future.

Additionally, exploring cloud-based solutions like Firebase for database management is on my radar. Its rich set of features for real-time data synchronization and automatic scaling is something I am excited to tap into. For this iteration, due to time constraints, the deployment was carried out on Heroku and Netlify, which offered simplicity and reliability for the project needs.

The development timeline was as follows:
- **Saturday & Sunday**: Focused on the backend, establishing the schema, data models, DAOs, exception handling, services, controllers, and testing with Postman.
- **Monday**: Developed the frontend, specifically the router, service, and views for Inventory and History, as well as the Fish and History Forms.
- **Tuesday**: Continued frontend work, concentrating on authorization and various components, along with the Info view.
- **Wednesday**: Finalized frontend styling and began the deployment process.
- **Thursday**: Dedicated to creating the ReadMe and making final adjustments.

The project was both challenging and rewarding, providing a rich learning experience. I'm proud of the progress made within the given time frame and hopeful that it meets your expectations. Your feedback is invaluable, so please feel free to share any thoughts or questions you might have. I'm eager to discuss any aspect of the project and am ready to make further improvements based on your input.

Thank you for considering my work. I am excited about the potential to further discuss how my project aligns with your objectives and to explore opportunities for contributing to your team.

Best regards,
Adam Mills