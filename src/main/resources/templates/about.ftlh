<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About - Marvel Character Gallery</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .about-container {
            max-width: 800px;
            margin: 40px auto;
            padding: 0 20px;
            color: #333333;
            line-height: 1.6;
        }

        .about-section {
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 25px;
            margin-bottom: 25px;
        }

        .about-section h1, 
        .about-section h2 {
            color: #111111;
            margin-top: 0;
        }

        .about-image {
            width: 100%;
            max-height: 400px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 25px;
            display: block;
        }
    </style>
</head>

<body>

    <nav>
        <a href="index.html">Home</a>
        <a href="details.html">Details</a>
        <a href="about.html">About</a>
        <a href="new-character-form.html">Add a Character</a>
    </nav>

    <main class="about-container">
        
        <!-- image  -->
        <img src="images/about.jpg" alt="About Gallery" class="about-image">

        <!-- introduction -->
        <section class="about-section">
            <h1>Marvel Character Gallery</h1>
            <p>This page shows some of marvels heroes and allows you to learn more about them and also add characters that you like as well.</p>
        </section>

        <!-- Inspiration -->
        <section class="about-section">
            <h2>Inspiration</h2>
            <p>I designed the website using a red and black color scheme to give it a strong Marvel-inspired appearance. The red background helps represent the red associated with Marvel, while the black background gives the website a darker and more dramatic look. The combination of red and black also has a personal meaning to me because it represents Blade, who is an important Marvel character to me. I wanted the design to reflect both the Marvel theme and my connection to the character.</p>
        </section>

    </main>

</body>
</html>