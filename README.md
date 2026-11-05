# Marvel Characters

A Spring Boot web app and REST API for managing **Marvel characters** (heroes such as Spider-Man, Iron Man, Black Panther, Blade, and Storm). Pages are built on the server with FreeMarker templates, data lives in a Neon PostgreSQL database, and the app is deployed on Render with Docker.

**Live site (home page):** https://marvel-characters-api-4pjf.onrender.com/
**Live API:** https://marvel-characters-api-4pjf.onrender.com/api/characters

> **Cold-start note:** this runs on Render's free tier, which sleeps when idle. The first request after a quiet period can take about a minute to respond.

## Pages

| Route | Description |
|---|---|
| `GET /` | Gallery of character cards with name search and role filter (`?name=...&role=...`) |
| `GET /characters/{id}` | Details page with Edit and Delete buttons |
| `GET /about` | About page, including how the app is built |
| `GET /characters/new` | Add form |
| `POST /characters` | Saves a new character, then redirects to the gallery |
| `GET /characters/{id}/edit` | Edit form, pre-filled |
| `POST /characters/{id}` | Saves changes, then redirects to the details page |
| `POST /characters/{id}/delete` | Deletes the character (with confirmation), then redirects to the gallery |

An unknown ID shows a friendly "Page not found" page.

## Entity: `MarvelCharacter` (table `characters`)

| Attribute | Type | Rules |
|---|---|---|
| `characterId` | Long | Unique, auto-generated |
| `name` | String | Required (not null, not blank) |
| `description` | String | Required (not null, not blank) |
| `species` | String | Optional |
| `role` | String | Optional |
| `imageUrl` | String | Optional (a placeholder is shown when empty) |

## REST API Endpoints

| Method | Path | Description | Success Status |
|---|---|---|---|
| GET | `/api/characters` | Get all characters | 200 |
| GET | `/api/characters/{id}` | Get one character by ID | 200 |
| POST | `/api/characters` | Add a character | 201 |
| PUT | `/api/characters/{id}` | Update a character | 200 |
| DELETE | `/api/characters/{id}` | Delete a character | 204 |
| GET | `/api/characters?role=Hero` | Filter by role (case-insensitive) | 200 |
| GET | `/api/characters?name=abc` | Search by name (partial, case-insensitive) | 200 |

Errors: `404` for an unknown ID, `400` when `name` or `description` is missing or blank.

Example request body for POST and PUT:

```json
{
  "name": "Storm",
  "description": "Ororo Munroe, an X-Men member who can control the weather.",
  "species": "Mutant",
  "role": "Hero",
  "imageUrl": "/images/storm.jpg"
}
```

## How it is built

Entity, Repository, Service, and two controllers (a page controller for HTML and a REST controller for JSON). Both controllers use the same service; neither touches the repository directly. Configuration is read from the `SPRING_DATASOURCE_URL` environment variable; no secrets are stored in the repository.
