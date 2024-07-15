# Media Rental Manager

This repository contains a media rental manager system implemented in Java. The system allows managing customers and media (movies and albums), including adding customers and media, processing rental requests, and returning media.

## Classes Overview

### Customers
Represents a customer who can rent and queue media.

**Fields:**
- `name`: The name of the customer.
- `address`: The address of the customer.
- `plan`: The rental plan of the customer.
- `rentedList`: List of media currently rented by the customer.
- `queueList`: List of media queued for rental by the customer.
- `numRented`: Number of media items currently rented by the customer.

**Methods:**
- Add/remove media to/from rented and queued lists.
- Check rental/queue limits.
- Compare customers by name.

### Media
Represents a generic media item.

**Fields:**
- `title`: The title of the media item.
- `copiesAvailable`: The number of available copies.

**Methods:**
- Get/set title and copies available.
- Check availability.
- Increase/decrease copies.
- Compare media by title.

### MediaRentalManager
Manages customers and media, handles rental processes.

**Fields:**
- `customersList`: List of customers.
- `mediaList`: List of media items.
- `limitedPlanLimit`: The limit for the limited plan.

**Methods:**
- Add customer.
- Add movie.
- Add album.
- Set/get limited plan limit.
- Get customer/media info.
- Add/remove media to/from queue.
- Process requests.
- Return media.
- Search media.

### MediaRentalManagerInt
Interface defining the media rental manager's functionality.

**Methods:**
- Add customer.
- Add movie.
- Add album.
- Set limited plan limit.
- Get customer/media info.
- Add/remove media to/from queue.
- Process requests.
- Return media.
- Search media.

### Movies
Extends Media to represent movies.

**Fields:**
- `rating`: The rating of the movie.

**Methods:**
- Get rating.

### MusicAlbums
Extends Media to represent music albums.

**Fields:**
- `artist`: The artist of the album.
- `songs`: The songs in the album.

**Methods:**
- Get artist.
- Get songs.
