#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/kobject.h>
#include <linux/sysfs.h>
#include <linux/thermal.h>

static struct kobject *temp_kobj;

static ssize_t temp_show(struct kobject *kobj, struct kobj_attribute *attr, char *buf)
{
    struct thermal_zone_device *tz;
    int temp_millic, ret;

    tz = thermal_zone_get_zone_by_name("cpu-thermal");
    if (IS_ERR(tz))
        return sysfs_emit(buf, "Error: cannot find default thermal zone\n");

    ret = thermal_zone_get_temp(tz, &temp_millic);
    if (ret)
        return sysfs_emit(buf, "Error: cannot read temp\n");

    return sysfs_emit(buf, "%d\n", temp_millic / 1000);
}

static struct kobj_attribute temp_attribute = __ATTR(value, 0444, temp_show, NULL);

static int __init temp_init(void)
{
    int error = 0;

    temp_kobj = kobject_create_and_add("temp", kernel_kobj);
    if (!temp_kobj)
        return -ENOMEM;

    error = sysfs_create_file(temp_kobj, &temp_attribute.attr);
    if (error) {
        pr_err("temp: failed to create sysfs file\n");
        kobject_put(temp_kobj);
    }

    pr_info("temp module loaded\n");
    return error;
}

static void __exit temp_exit(void)
{
    kobject_put(temp_kobj);
    pr_info("temp module unloaded\n");
}

module_init(temp_init);
module_exit(temp_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Jeremy Singer");
MODULE_DESCRIPTION("Kernel module exposing integer Celsius temp via sysfs");
