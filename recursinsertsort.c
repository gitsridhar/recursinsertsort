#include <stdio.h>

void recursinsertsort(int data[], int n) {
    if (n <= 1)
        return;

    recursinsertsort(data, n-1);
    int lastelement = data[n-1];
    int temp = n-2;

    while(temp >= 0 && data[temp] > lastelement) {
        data[temp+1] = data[temp];
        temp--;
    }
    data[temp+1] = lastelement;
}

int main() {
    int data[] = {1,9,2,8,3,7,4,6,5};

    recursinsertsort(data, sizeof(data)/sizeof(data[0]));

    for (int i=0; i<sizeof(data)/sizeof(data[0]); i++) {
        printf("%d ", data[i]);
    }
    return 0;
}
