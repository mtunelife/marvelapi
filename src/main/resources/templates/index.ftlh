<#import "layout.ftlh" as l>
<@l.page title="Home">

    <header>
        <h1>Marvel Character Gallery</h1>
    </header>

    <form class="search-container" method="get" action="/">
        <input type="text" name="name" value="${name}" placeholder="Search heroes by name...">
        <select name="role">
            <option value="">All roles</option>
            <#list roles as r>
                <option value="${r}"<#if r?lower_case == role?lower_case> selected</#if>>${r}</option>
            </#list>
        </select>
        <button type="submit">Search</button>
        <#if name?has_content || role?has_content>
            <a class="clear-link" href="/">Clear</a>
        </#if>
    </form>

    <#if characters?has_content>
        <main class="gallery-grid">
            <#list characters as c>
                <#assign img = c.imageUrl?has_content?then(c.imageUrl, "/images/placeholder.svg")>
                <a class="card-link" href="/characters/${c.characterId?c}">
                    <article class="character-card">
                        <h2>${c.name}</h2>
                        <img src="${img}" alt="${c.name}">
                        <div class="character-details">
                            <p><strong>Role:</strong> ${c.role?has_content?then(c.role, "Unknown")}</p>
                            <p><strong>Species:</strong> ${c.species?has_content?then(c.species, "Unknown")}</p>
                        </div>
                    </article>
                </a>
            </#list>
        </main>
    <#else>
        <p class="empty-message">No characters found.</p>
    </#if>

</@l.page>
