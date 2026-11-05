<#import "layout.ftlh" as l>
<@l.page title=formTitle>

    <header>
        <h1>${formTitle}</h1>
        <p>Fields marked * are required.</p>
    </header>

    <form class="character-form" method="post" action="${formAction}">

        <div class="form-group">
            <label for="name">Character Name *</label>
            <input type="text" id="name" name="name" value="${character.name!''}" placeholder="Enter character name">
            <#if errors.name??><span class="field-error">${errors.name}</span></#if>
        </div>

        <div class="form-group">
            <label for="species">Species</label>
            <input type="text" id="species" name="species" value="${character.species!''}" placeholder="Example: Mutant">
        </div>

        <div class="form-group">
            <label for="role">Role</label>
            <input type="text" id="role" name="role" value="${character.role!''}" placeholder="Example: Hero">
        </div>

        <div class="form-group">
            <label for="imageUrl">Image URL</label>
            <input type="text" id="imageUrl" name="imageUrl" value="${character.imageUrl!''}" placeholder="https://example.com/image.jpg">
        </div>

        <div class="form-group">
            <label for="description">Description *</label>
            <textarea id="description" name="description" rows="5" placeholder="Enter a short description...">${character.description!''}</textarea>
            <#if errors.description??><span class="field-error">${errors.description}</span></#if>
        </div>

        <div class="actions">
            <button type="submit">${submitLabel}</button>
            <a class="button" href="/">Cancel</a>
        </div>

    </form>

</@l.page>
