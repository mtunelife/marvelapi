<#import "layout.ftlh" as l>
<@l.page title=character.name>

    <main class="card details-card">

        <#assign img = character.imageUrl?has_content?then(character.imageUrl, "/images/placeholder.svg")>
        <img class="details-image" src="${img}" alt="${character.name}">

        <h2>${character.name}</h2>

        <p><strong>Role:</strong> ${character.role?has_content?then(character.role, "Unknown")}</p>
        <p><strong>Species:</strong> ${character.species?has_content?then(character.species, "Unknown")}</p>
        <p><strong>Description:</strong> ${character.description}</p>

        <div class="actions">
            <a class="button" href="/">&larr; Back to gallery</a>
            <a class="button" href="/characters/${character.characterId?c}/edit">Edit</a>

            <form method="post" action="/characters/${character.characterId?c}/delete"
                  onsubmit="return confirm('Are you sure you want to delete this character?');">
                <button type="submit" class="danger">Delete</button>
            </form>
        </div>

    </main>

</@l.page>
