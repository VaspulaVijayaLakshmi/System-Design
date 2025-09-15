https://www.hellointerview.com/learn/system-design/deep-dives/redis


Redis can run as a single node, with a high availability (HA) replica, or as a cluster.


When operating as a cluster, Redis clients cache a set of "hash slots" which map keys to a specific node.

Redis does not use consistent hashing

Fixed "HASH SLOTS"

