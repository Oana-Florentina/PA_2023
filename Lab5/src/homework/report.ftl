<html>
<head>
    <title>Document Report</title>
</head>
<body>
    <h1>Document Report</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Tags</th>
                <th>URL</th>
            </tr>
        </thead>
        <tbody>
            <#list documents as document>
                <tr>
                    <td>${document.id}</td>
                    <td>${document.name}</td>
                    <td>
                        <ul>
                            <#list document.tags?keys as key>
                                <li>${key}: ${document.tags[key]}</li>
                            </#list>
                        </ul>
                    </td>
                    <td><a href="${document.url}">${document.url}</a></td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
