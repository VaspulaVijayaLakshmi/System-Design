<img width="1728" height="1117" alt="Screenshot 2026-05-31 at 1 24 01 AM" src="https://github.com/user-attachments/assets/cbf7d7c5-3599-48de-89e3-3a54adbe1676" />


<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/bd0a330c-fa2a-463e-8cc9-76f19bdd46eb" />



Archive the image object to cold storage while retaining metadata in a database. Update metadata with archival status and cold-storage location so images remain searchable and retrievable without scanning cold storage.



# Image Archival System

## Metadata Database

| Field | Value |
|---------|---------|
| imageId | 123 |
| userId | 456 |
| createdAt | 2026-06-11T10:00:00Z |
| storageType | COLD |
| location | s3://cold-bucket/123.jpg |
| status | ARCHIVED |

---

## Cold Storage

```text
cold-bucket/
└── 123.jpg
```

---




## Archival Flow

```text
Hot Storage
     │
     ▼
Archive Worker
     │
     ▼
Cold Storage

Metadata DB
(storageType=COLD,
 status=ARCHIVED,
 location=s3://cold-bucket/123.jpg)
```

---



## Retrieval Flow

```text
User Request
      │
      ▼
Metadata DB Lookup
      │
      ▼
storageType = COLD ?
      │
      ▼
Fetch Image From Cold Storage
      │
      ▼
Return Image
```

---


Why keep metadata in DB?

Search becomes fast.
No need to scan cold storage to find images.
User can still see image listings instantly.
Archival eligibility checks become easy.
Restore operations become easy.



__________________________________________________________________________________

Images are moved to cold storage. Metadata remains in the primary metadata database with an archive flag and storage location. If metadata itself becomes very large, we can introduce an archival metadata database and migrate old metadata there.


Why maintain both temporarily?

During migration:

1. Copy metadata to Archive DB
2. Verify copy succeeded
3. Delete from Primary DB

This avoids data loss.


_________________________________________________________________________________


Metadata can be partitioned based on image creation date. Since archival eligibility is time-based (e.g., older than 1 year), date-based partitioning makes archival operations efficient. Entire old partitions can be migrated to archive storage instead of scanning the entire metadata table.


_________________________________________________________________________________

Metadata can be partitioned based on image creation date. Since archival eligibility is time-based (e.g., older than 1 year), date-based partitioning makes archival operations efficient. Entire old partitions can be migrated to archive storage instead of scanning the entire metadata table.


"I would partition metadata month-wise based on creation date because archival is a time-based operation. This avoids full-table scans and makes archival jobs efficient."



