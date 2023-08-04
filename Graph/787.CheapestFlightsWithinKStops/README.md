# 787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

## Approach

High Level Idea: <br>
1. Initialize Heap with starting city marked with cost = 0 <br>
2. While heap is not empty: <br>
    a. Poll out one node <br>
    b. If node.stop > k or node is previously traversed with LESS STOPS, skip it <br>
    c. If this is the destination node, return node.cost <br>
    d. For all its neighbors, offer them to heap with current node's cost + edge cost (flight cost) <br>
