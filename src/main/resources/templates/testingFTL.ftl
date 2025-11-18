<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${subject?if_exists}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fafc;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .email-container {
            max-width: 600px;
            background-color: #ffffff;
            margin: 20px auto;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        .header {
            background-color: #0066cc;
            color: white;
            padding: 16px;
            text-align: center;
            font-size: 22px;
        }
        .content {
            padding: 24px;
            line-height: 1.6;
        }
        .button {
            display: inline-block;
            background-color: #0066cc;
            color: white;
            text-decoration: none;
            padding: 10px 18px;
            border-radius: 6px;
            margin-top: 12px;
        }
        .footer {
            background-color: #f2f2f2;
            text-align: center;
            padding: 14px;
            font-size: 12px;
            color: #777;
        }
    </style>
</head>
<body>
<div class="email-container">
    <div class="header">
        ${headerText?if_exists}
    </div>
    <div class="content">
        <p>Hi ${name},</p>
        <p>${bodyMessage?if_exists}</p>

        <#if actionUrl??>
            <p>
                <a href="${actionUrl}" class="button">Take Action</a>
            </p>
        </#if>

        <p>Thank you,<br/>The ${companyName?if_exists} Team</p>
    </div>
    <div class="footer">
        &copy; ${year?if_exists} ${companyName?if_exists}. All rights reserved.
    </div>
</div>
</body>
</html>
