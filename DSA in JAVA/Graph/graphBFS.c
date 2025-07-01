#include<stdio.h>
#include<stdlib.h>

struct que{
    int size;
    int f;
    int r;
    int *arr;
};

int visited[]= {0,0,0,0,0,0,0};
int graph[7][7] = {{0,1,1,0,0,0,0},
                        {1,0,0,1,0,0,0},
                        {1,0,0,0,1,0,0},
                        {0,1,0,0,1,1,0},
                        {0,0,1,1,0,1,0},
                        {0,0,0,1,1,0,1},
                        {0,0,0,0,0,1,0}};


int isFull(struct que *q)
{
    if(q->r == q->size-1)
    {
        return 1;
    }
    return 0;
}

int isEmpty(struct que *q)
{
    if(q->r==q->f)
    {
        return 1;
    }
    return 0;
}

void enQ(struct que *q, int data)
{
    if(isFull(q))
    {
        printf("Q is full");
    }
    else{
        q->arr[q->r] = data;
        q->r = q->r+1;

    }
}

int deQ(struct que *q)
{
    int data;
    if(isEmpty(q))
    {
        printf("Q is Empty");
    }
    else{
        data = q->arr[q->f];
        q->f++;
    }
    return data;
}

void BFS(int graph[7][7], struct que q){
    int i=5;

    visited[i] = 1;
    printf("%d",i);
    enQ(&q,i);
    while(!isEmpty(&q))
    {
        int node = deQ(&q);
        for(int j= 0; j<7; j++)
        {
            if(graph[node][j] == 1 && !visited[j])
            {
                printf("%d",j);
                visited[j] = 1;
                enQ(&q,j);
            }
        }

    }

}

void DFS(int i)
{
    printf("%d",i);
    visited[i] = 1;
    for(int j=0; j<7; j++)
    {
        if(graph[i][j] == 1 && visited[j]==0)
        {
            DFS(j);
        }
    }

}


int main(int argc, char const *argv[])
{
    struct que q;
    q.size = 400;
    q.f=q.r=0;
    q.arr = (int *)malloc(q.size*sizeof(int));

    /*
            1---3
        /       |  \
    0           |   5---6
        \       |  /
            2---4
    
    */
   
    
    

    BFS(graph,q);
    // DFS(5);

       return 0;
}
