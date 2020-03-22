import pymongo
from pymongo import MongoClient
import datetime

client = MongoClient('18.191.42.72', 27017)
db = client.IPLocation
records = db.records
record1 = {"IPAddress": "18.191.20.194", "lat": "40.72417", "lon": "-74.17250", "date": datetime.datetime(2020, 3, 10, 11, 14)}
record2 = {"IPAddress": "18.191.20.194", "lat": "40.71139", "lon": "-74.06472", "date": datetime.datetime(2020, 3, 11, 11, 14)}
record3 = {"IPAddress": "18.191.20.194", "lat": "40.91472", "lon": "-74.16278", "date": datetime.datetime(2020, 3, 12, 11, 14)}
record3 = {"IPAddress": "18.191.20.194", "lat": "40.85889", "lon": "-74.16278", "date": datetime.datetime(2020, 3, 12, 11, 14)}
record3 = {"IPAddress": "18.191.20.194", "lat": "40.05806", "lon": "-74.13722", "date": datetime.datetime(2020, 3, 12, 11, 14)}
record4 = {"IPAddress": "18.191.20.188", "lat": "40.66639", "lon": "-74.19361", "date": datetime.datetime(2020, 3, 13, 11, 14)}
record5 = {"IPAddress": "18.191.20.188", "lat": "40.51889", "lon": "-74.41194", "date": datetime.datetime(2020, 3, 14, 11, 14)}
record6 = {"IPAddress": "18.191.20.188", "lat": "40.56083", "lon": "-74.29250", "date": datetime.datetime(2020, 3, 15, 11, 14)}
record7 = {"IPAddress": "18.191.20.188", "lat": "40.07694", "lon": "-74.20028", "date": datetime.datetime(2020, 3, 16, 11, 14)}
record8 = {"IPAddress": "18.191.20.188", "lat": "40.22361", "lon": "-74.76389", "date": datetime.datetime(2020, 3, 17, 11, 14)}
# record_id = records.insert_one(record).inserted_id
result = records.insert_many([record1, record2, record3, record4, record5, record6, record7, record8])
result.inserted_ids




