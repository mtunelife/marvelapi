<#-- Shared layout: head, navigation, one-time success message, and the page content. -->
<#macro page title="Home">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title} - Marvel Character Gallery</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

    <nav>
        <a href="/">Home</a>
        <a href="/about">About</a>
        <a href="/characters/new">Add a Character</a>
    </nav>

    <#if flashMessage??>
        <div class="flash">${flashMessage}</div>
    </#if>

    <#nested>

</body>
</html>
</#macro>
