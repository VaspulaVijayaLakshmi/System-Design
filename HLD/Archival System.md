<img width="1728" height="1117" alt="Screenshot 2026-05-31 at 1 24 01 AM" src="https://github.com/user-attachments/assets/cbf7d7c5-3599-48de-89e3-3a54adbe1676" />


<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/bd0a330c-fa2a-463e-8cc9-76f19bdd46eb" />



Archive the image object to cold storage while retaining metadata in a database. Update metadata with archival status and cold-storage location so images remain searchable and retrievable without scanning cold storage.


Flow:

Metadata DB
----------------------------------
imageId = 123
userId = 456
createdAt = ...
storageType = COLD
location = s3://cold-bucket/123.jpg
status = ARCHIVED
----------------------------------

Cold Storage
----------------------------------
123.jpg
----------------------------------




Why keep metadata in DB?

Search becomes fast.
No need to scan cold storage to find images.
User can still see image listings instantly.
Archival eligibility checks become easy.
Restore operations become easy.



Retrieval:

User requests image
        ↓
Metadata DB lookup
        ↓
storageType = COLD ?
        ↓
Fetch from cold storage
        ↓
Return image


__________________________________________________________________________________

Images are moved to cold storage. Metadata remains in the primary metadata database with an archive flag and storage location. If metadata itself becomes very large, we can introduce an archival metadata database and migrate old metadata there.


Why maintain both temporarily?

During migration:

1. Copy metadata to Archive DB
2. Verify copy succeeded
3. Delete from Primary DB

This avoids data loss.
