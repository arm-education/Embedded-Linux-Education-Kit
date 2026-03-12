### CC = arm-linux-gnueabihf-gcc 
obj-m := temp.o
SRC := $(shell pwd)
all:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)

modules_install:
	$(MAKE) INSTALL_MOD_DIR=kernel/drivers/aup -C $(KERNEL_SRC) M=$(SRC) modules_install

clean:
	rm -f *.o *~core.depend .*.cmd *.ko *.mod.c gpio_simple_test 
	rm -f Module.markers Module.symvers modules.order
	rm -rf .tmp_versions Modules.symvers
