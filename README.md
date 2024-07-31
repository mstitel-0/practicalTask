# Github Fetcher

This project uses Github REST API to fecth repositories.
It aims to fetch repositotiries for a given user and retrieve all the repositories which are not forks with all corresponding branches names and sha of the last commit.

## Features

- Fetches repositories for the given user
- Displays all repositories which are not forks
- Show information like: repository name, owner login and all bracnhes 
- For each branch displays: name and last commit sha

## Requirements

- Java version 21

## Usage

While running an application, you can use next API endpoint to get all repositories for a given username.

## API Reference

#### Get all repositories which are not forks

```http
  GET /api/v1/github/repos/{username}
```

| Path parameters | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | **Required**. Repositories owner's login|

| Header | Value     | Description |
| :-------- | :------- | :-------------------------------- |
| `Accept`| `application/json` | Produces **JSON** response |

## Example

```http
  GET /api/v1/github/repos/helloworld
```

#### Responses ####

- **200 OK**: Successful response with the list of repositories.
```json
[
    {
        "name": "hello",
        "ownerLogin": "helloworld",
        "branches": [
            {
                "name": "main",
                "sha": "1d4ecc9a9c40e01ddb040f5deec5b6254caead1f"
            }
        ]
    }
]
```

- **404 Not found**: The given user does not exist.
```json
{
    "status": "404",
    "message": "Not Found"
}
```
