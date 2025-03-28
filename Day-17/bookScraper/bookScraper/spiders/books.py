import scrapy
from bookScraper.items import BookscraperItem

class BooksSpider(scrapy.Spider):
    name = "books"
    allowed_domains = ["books.toscrape.com"]
    start_urls = ["https://books.toscrape.com/"]

    def parse(self, response):
        for book in response.css("article.product_pod"):
            item = BookscraperItem()
            
            item['title'] = book.css("h3 a::attr(title)").get()
            item['price'] = book.css(".price_color::text").get()
            rating_class = book.css("p.star-rating::attr(class)").get()
            item['rating'] = rating_class.split()[-1] if rating_class else "Not Rated"
            availability_text = book.css(".instock.availability ::text").getall()
            avail = " ".join(text.strip() for text in availability_text if text.strip())
            parts = avail.split()
            print(parts[0])
            item['availability'] = parts[0]

            yield item

        next_page = response.css("li.next a::attr(href)").get()
        if next_page:
            yield response.follow(next_page, callback=self.parse)
