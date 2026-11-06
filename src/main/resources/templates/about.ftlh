<#import "layout.ftlh" as l>
<@l.page title="About">

    <main class="about-container">

        <img src="/images/about.jpg" alt="About Gallery" class="about-image">

        <section class="about-section">
            <h1>Marvel Character Gallery</h1>
            <p>This app shows some of Marvel's heroes and lets you learn more about them. You can search the gallery, and you can also add, edit, and remove the characters that you like.</p>
        </section>

        <section class="about-section">
            <h2>Inspiration</h2>
            <p>I designed the site with a red and black color scheme to give it a strong Marvel-inspired look. The red represents the red associated with Marvel, while the black gives the site a darker, more dramatic feel. The combination also has a personal meaning to me because it represents Blade, who is an important Marvel character to me. I wanted the design to reflect both the Marvel theme and my connection to the character.</p>
        </section>

        <section class="about-section">
            <h2>How this app is built</h2>
            <p>The app is a Spring Boot project that is split into layers, and each layer only talks to the one next to it:</p>
            <ul>
                <li><strong>Database:</strong> a Neon PostgreSQL database stores every character.</li>
                <li><strong>Repository:</strong> a Spring Data JPA repository reads and writes the <em>characters</em> table.</li>
                <li><strong>Service:</strong> the service layer holds the logic, such as searching, creating, updating, and deleting.</li>
                <li><strong>Controllers:</strong> a page controller builds the web pages you are looking at, and a separate REST controller serves the JSON API at <code>/api/characters</code>.</li>
                <li><strong>Templates:</strong> FreeMarker templates turn the data into HTML on the server, and they share one layout so the navigation is the same on every page.</li>
            </ul>
            <p>Both controllers call the same service, so the web pages and the API always show the same data. The app is packaged with Docker and hosted on Render.</p>
        </section>

    </main>

</@l.page>
