import heapq

class PriorityQueue:
    def __init__(self):
        self.heap = []  # Min-heap to store elements

    def push(self, item, priority):
        heapq.heappush(self.heap, (-priority, item))  # Store negative priority for max-heap
        print(f"Added item: '{item}' with priority: {priority}")

    def pop(self):
        if not self.is_empty():
            priority, item = heapq.heappop(self.heap)  # Extract max-priority item
            print(f"Popped item: '{item}' with priority: {-priority}")
            return item
        else:
            print("Priority queue is empty!")

    def peek(self):
        if not self.is_empty():
            priority, item = self.heap[0]  # Get highest priority item without removing
            print(f"Highest priority item: '{item}' with priority: {-priority}")
            return item
        else:
            print("Priority queue is empty!")

    def is_empty(self):
        return len(self.heap) == 0

    def display(self):
        if not self.is_empty():
            sorted_items = sorted(self.heap, reverse=True)  # Sort heap to show priority order
            print("Current Queue (Sorted by Priority):")
            for priority, item in sorted_items:
                print(f"  Item: '{item}', Priority: {-priority}")
        else:
            print("Priority queue is empty!")

# Taking user input to test the priority queue
pq = PriorityQueue()

while True:
    print("\nChoose an operation:")
    print("1. Add an item")
    print("2. Pop the highest priority item")
    print("3. Peek at the highest priority item")
    print("4. Display queue")
    print("5. Exit")
    
    choice = input("Enter your choice: ")

    if choice == "1":
        item = input("Enter item name: ")
        priority = int(input("Enter priority (higher value = higher priority): "))
        pq.push(item, priority)
    elif choice == "2":
        pq.pop()
    elif choice == "3":
        pq.peek()
    elif choice == "4":
        pq.display()
    elif choice == "5":
        print("Exiting the program. Goodbye!")
        break
    else:
        print("Invalid choice! Please try again.")