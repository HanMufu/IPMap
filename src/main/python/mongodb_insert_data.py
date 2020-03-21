import pymongo
from pymongo import MongoClient
import datetime

client = MongoClient('18.191.42.72', 27017)
db = client.IPLocation
records = db.records
# record1 = {"IPAddress": "18.191.20.494", "lon": "40.61889", "lat": "-74.51194", \
#     "date": datetime.datetime(2020, 3, 10, 11, 14)}
# record2 = {"IPAddress": "18.191.20.494", "lon": "40.71889", "lat": "-74.61194", \
#     "date": datetime.datetime(2020, 3, 11, 11, 14)}
# record3 = {"IPAddress": "18.191.20.494", "lon": "40.21889", "lat": "-74.21194", \
#     "date": datetime.datetime(2020, 3, 12, 11, 14)}
# record4 = {"IPAddress": "18.191.20.388", "lon": "39.51889", "lat": "-73.21194", \
#     "date": datetime.datetime(2020, 3, 13, 11, 14)}
# record5 = {"IPAddress": "18.191.20.388", "lon": "39.61889", "lat": "-73.31194", \
#     "date": datetime.datetime(2020, 3, 14, 11, 14)}
# record6 = {"IPAddress": "18.191.20.388", "lon": "39.71889", "lat": "-73.41194", \
#     "date": datetime.datetime(2020, 3, 15, 11, 14)}
# record7 = {"IPAddress": "18.191.20.388", "lon": "39.81889", "lat": "-73.51194", \
#     "date": datetime.datetime(2020, 3, 16, 11, 14)}
# record8 = {"IPAddress": "18.191.20.388", "lon": "39.91889", "lat": "-73.61194", \
#     "date": datetime.datetime(2020, 3, 17, 11, 14)}
# result = records.insert_many([record1, record2, record3, record4, record5, record6, record7, record8])

record1 = {"IPAddress": "18.191.20.494", "lon": "40.91889", "lat": "-74.91194", \
    "date": datetime.datetime(2020, 3, 10, 11, 14).timestamp()}
record_id = records.insert_one(record1).inserted_id
result.inserted_ids




