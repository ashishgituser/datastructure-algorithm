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

Adding Element at the end :-
-----------------------------

|null|data|next| <-> |pre|data|next| <-> |pre|data|null|

How to add new Node at the end of list.

1. Check if head is null, if head is null -> make new node's pre and next null and make it head.
2. If head is not null -> make new node's next null, pre to the last node. Last node's next to new node.
3. Update the lenght of the list.