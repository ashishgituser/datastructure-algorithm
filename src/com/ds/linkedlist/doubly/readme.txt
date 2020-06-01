Doubly Linked List :-
-------------------------

Doubly linked list is also called two way linked list. We can move in both direction.
Although, it requires extra space to store both the pointers in the node.

Adding Element at begning :-
-------------------------------

|null|data|next| <-> |pre|data|next| <-> |pre|data|null|

How to add new Node to head.

1. Create new node. Assign data, make new node's pre as NULL and next HEAD.
2. Assign head pre to new node.
3. Now make new node as head.
4. Update list length.