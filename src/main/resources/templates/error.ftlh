<#import "layout.ftlh" as l>
<@l.page title="Not Found">

    <main class="card error-card">
        <h2>Page not found</h2>
        <p>${errorMessage!"The page you were looking for doesn't exist."}</p>
        <div class="actions">
            <a class="button" href="/">&larr; Back to gallery</a>
        </div>
    </main>

</@l.page>
