Create the pending_user table <br><br>

CREATE TABLE pending_user ( <br>
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, <br>
    username VARCHAR(255) NOT NULL, <br>
    nrc_number VARCHAR(255) NOT NULL, <br>
    user_email VARCHAR(255) NOT NULL, <br>
    career VARCHAR(255) NOT NULL, <br>
    hashed_password VARCHAR(255) NOT NULL, <br>
    account_number VARCHAR(255) NOT NULL, <br>
    otp VARCHAR(10) NOT NULL <br>
);
<br>
updated the email authantication <br>
added the reset password
