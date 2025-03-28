# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import pymongo
from scrapy.utils.project import get_project_settings


class BookscraperPipeline:
    def process_item(self, item, spider):
        return item


class MongoDBPipeline:
    def open_spider(self, spider):
        settings = get_project_settings()
        self.mongo_uri = settings.get("MONGO_URI")
        self.mongo_db = settings.get("MONGO_DB")
        self.mongo_collection = settings.get("MONGO_COLLECTION")

        self.client = pymongo.MongoClient(self.mongo_uri)
        self.db = self.client[self.mongo_db]
        self.collection = self.db[self.mongo_collection]

    def process_item(self, item, spider):
        self.collection.insert_one(dict(item))
        return item

    def close_spider(self, spider):
        self.client.close()
