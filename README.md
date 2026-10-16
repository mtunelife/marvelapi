# marvelapi
# Marvel Characters API

## About the App

This is a REST API built with **Spring Boot** that stores and manages **Marvel characters**. It is the back-end version of my earlier Marvel Character Gallery static web app, which featured heroes such as Spider-Man, Iron Man, Black Panther, Blade, and Storm.

- **Character type:** Marvel characters (heroes, villains, and anti-heroes(aka blade))
- **Tech stack:** Java 25, Spring Boot, Spring Data JPA, Neon (PostgreSQL), Docker
- **Hosting:** Deployed on Render as a Docker web service

## Entity: `MarvelCharacter` (table name: `characters`)

| Attribute | Type | Rules |
|---|---|---|
| `characterId` | Long | Unique, auto-generated |
| `name` | String | Required (not null, not blank) |
| `description` | String | Required (not null, not blank) |
| `species` | String | Optional (e.g. Human, Mutant, Enhanced Human) |
| `role` | String | Optional (e.g. Hero, Villain, Anti-Hero) |

## API Endpoints

Base path: `/api/characters`

| Method | Path | Description | Success Status |
|---|---|---|---|
| GET | `/api/characters` | Get all characters | 200 |
| GET | `/api/characters/{id}` | Get one character by ID | 200 |
| POST | `/api/characters` | Add a new character | 201 |
| PUT | `/api/characters/{id}` | Update an existing character | 200 |
| DELETE | `/api/characters/{id}` | Delete a character | 204 |
| GET | `/api/characters?role=Hero` | Filter characters by role (case-insensitive) | 200 |
| GET | `/api/characters?name=abc` | Search characters by name (partial, case-insensitive) | 200 |

### Example POST request body

`POST /api/characters`

```json
{
  "name": "Storm",
  "description": "Ororo Munroe, an X-Men member who can control the weather.",
  "species": "Mutant",
  "role": "Hero"
}
```

### Example PUT request body

`PUT /api/characters/1`

```json
{
  "name": "Storm",
  "description": "Ororo Munroe, a mutant and longtime X-Men leader who can control the weather.",
  "species": "Mutant",
  "role": "Hero"
}
```

### Error responses

| Status | When it happens |
|---|---|
| 400 Bad Request | `name` or `description` is missing or blank |
| 404 Not Found | No character exists with the requested ID |

## Deployed API

**Live URL:** https://YOUR-SERVICE-NAME.onrender.com/api/characters
