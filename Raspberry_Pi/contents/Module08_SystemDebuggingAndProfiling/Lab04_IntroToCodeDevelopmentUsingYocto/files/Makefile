CC=aarch64-poky-linux-gcc --sysroot=/opt/poky/5.0.11/sysroots/cortexa76-poky-linux/
LD=aarch64-poky-linux-ld --sysroot=/opt/poky/5.0.11/sysroots/cortexa76-poky-linux/
CFLAGS=-O2 -pipe -g -feliminate-unused-debug-types

all: hello

hello.o: hello.c

hello: hello.o
	$(CC) $(CFLAGS) -o hello hello.c

clean:
	rm -f hello hello.o
