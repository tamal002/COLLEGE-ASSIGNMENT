from collections import OrderedDict, defaultdict

def get_stock_data():
    """Takes user input for stock names and prices and returns an ordered dictionary."""
    stocks = OrderedDict()
    n = int(input("Enter the number of stocks: "))
    
    for _ in range(n):
        stock_name = input("Enter stock name: ").strip()
        stock_price = float(input(f"Enter price for {stock_name}: "))
        stocks[stock_name] = stock_price
    
    return stocks

# Step 1: Take input for two stock dictionaries
print("Enter details for the first stock dictionary:")
stocks1 = get_stock_data()

print("\nEnter details for the second stock dictionary:")
stocks2 = get_stock_data()

# Step 2: Find the minimum and maximum price in the first dictionary
min_stock = min(stocks1.items(), key=lambda x: x[1])
max_stock = max(stocks1.items(), key=lambda x: x[1])

print("\nStock with Minimum Price:", min_stock)
print("Stock with Maximum Price:", max_stock)

# Step 3: Sort the first dictionary by price
sorted_stocks1 = OrderedDict(sorted(stocks1.items(), key=lambda x: x[1]))
print("\nFirst Dictionary Sorted by Price:", sorted_stocks1)

# Step 4: Find items only in the first dictionary
only_in_first = set(stocks1.keys()) - set(stocks2.keys())
print("\nStocks only in first dictionary:", only_in_first)

# Step 5: Find items whose prices do not match
price_mismatch = {key: (stocks1[key], stocks2[key]) for key in stocks1 if key in stocks2 and stocks1[key] != stocks2[key]}
print("\nStocks with price mismatches:", price_mismatch)

# Step 6: Remove duplicate stock entries (based on price)
unique_prices = {}
for stock, price in stocks1.items():
    if price not in unique_prices.values():
        unique_prices[stock] = price
stocks1 = OrderedDict(unique_prices)
print("\nFirst Dictionary after removing duplicates:", stocks1)

# Step 7: Sort both dictionaries in increasing price order
sorted_stocks1 = OrderedDict(sorted(stocks1.items(), key=lambda x: x[1]))
sorted_stocks2 = OrderedDict(sorted(stocks2.items(), key=lambda x: x[1]))

print("\nSorted First Dictionary:", sorted_stocks1)
print("Sorted Second Dictionary:", sorted_stocks2)

# Step 8: Group items in first dictionary by price in multiples of 500
grouped_by_500 = defaultdict(list)
for stock, price in stocks1.items():
    group_key = (int(price) // 500) * 500  # Group by nearest lower multiple of 500
    grouped_by_500[group_key].append((stock, price))

print("\nStocks grouped by price multiples of 500:")
for price_range, items in grouped_by_500.items():
    print(f"Price range {price_range}-{price_range+499}: {items}")

# Step 9: Find an item with price = 800 in both dictionaries
item_800_stock1 = [stock for stock, price in stocks1.items() if price == 800]
item_800_stock2 = [stock for stock, price in stocks2.items() if price == 800]

print("\nStocks with price 800 in First Dictionary:", item_800_stock1)
print("Stocks with price 800 in Second Dictionary:", item_800_stock2)