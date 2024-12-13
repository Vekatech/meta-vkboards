# meta-vkboards
BitBake recipes for various vkboards
#
1. create source dir [^1][^2]
    ``` bash
    mkdir -p $HOME/work/yocto/rz<x>_vlp_v<M>.<m>.<mod>
    cd $HOME/work/yocto/rz<x>_vlp_v<M>.<m>.<mod>
    ```

3. download source archives 
# Make sure that the following packages have been downloaded from the official website https://www.renesas.com
# For RZ/V Verified Linux Package [5.10-CIP]  V3.0.6 these are:
    RTK0EF0045Z0024AZJ-v3.0.6.zip
    RTK0EF0045Z13001ZJ-v1.2.2_EN.zip
    RTK0EF0045Z15001ZJ-v1.2.2_EN.zip
    r11an0549ej0750-rzv2l-drpai-sp.zip
    r11an0845ej0110-rzv2l-opencv-accelerator-sp.zip
    r01an7254ej0210_rzv-multi-os-pkg.zip
    oss_pkg_rzv_v3.0.6.7z
# For RZ/G Verified Linux Package [5.10-CIP]  V3.0.6 these are:
    RTK0EF0045Z0021AZJ-v3.0.6-update3.zip,
    RTK0EF0045Z13001ZJ-v1.2.2_EN.zip,
    RTK0EF0045Z15001ZJ-v1.2.2_EN.zip,
    r01an5869ej0210-rzg-multi-os-pkg.zip,
    oss_pkg_rzg_v3.0.6.7z

3. create working dir [^2]
    ``` bash
    mkdir -p $HOME/work/yocto/vlp_v<M>.<m>.<mod>/yocto
    cd $HOME/work/yocto/vlp_v<M>.<m>.<mod>/yocto
    ```
   
5. get helper utils
    ``` https
    wget https://raw.githubusercontent.com/Vekatech/yocto/main/create_yocto_src.sh
    wget https://raw.githubusercontent.com/Vekatech/yocto/main/run_docker
    ```

6. make utils executable
    ``` bash
    chmod a+x create_yocto_src.sh
    chmod a+x run_docker
    ```

7. modify "create_yocto_src.sh" by editing the following paths [^1][^2][^3]
    ```
    PKGKDIR=$HOME/work/yocto/rz<x>_vlp_v<M>.<m>.<mod> - directory with source archives
    WORKSPACE=$(pwd)                                  - working path
    YOCTO_HOME="${WORKSPACE}/v<M>.<m>.<mod>-<x>2l"    - yocto dir
    BUILD_DIR="<board>"                               - build dir 
    ```
   !This step is mandatory only if you have renamed the **`source dir`** or **`working dir`**. !
   If you have kept the original names for `source dir` and `working dir`, no edits are necessary.
   The script automatically adjusts the paths based on the location of **`create_yocto_src.sh`**.

8. create yocto sources [^3]
    ``` sh
    ./create_yocto_src.sh <board>
    ```

9. start docker (optional)
    ``` sh
    ./run_docker
    ```

10. go to YOCTO_HOME [^1][^2]
    ``` 
    cd v<M>.<m>.<mod>-<x>2l
    ```

11. `TEMPLATECONF=$PWD/meta-vkboards/meta-vk<x>2l/docs/template/conf` [^1]

12. `source poky/oe-init-build-env <board>` [^3]

13. adjust layers
    ```
    bitbake-layers add-layer ../meta-xxx
    ```

14. start a build [^3][^4]
    ``` bash
    MACHINE=<board> bitbake core-image-<target>
    ```

[^1]: `<x>` can be one of **RZ** sub families: [ **`v`** | **`g`** ]
[^2]: `<M>` `<m>` & `<mod>` are **M**ajor **m**inor & **mod**ifier digits of the VLP pakage you are trying to build: [ **`0`** - **`9`** ]
[^3]: `<board>` can be one of the boards: [ **`vkrzv2l`** | **`vkrzg2l`** | **`vkrzg2lc`** | **`vkrzg2ul`** | **`vkcmg2lc`** | **`vk-d184280e`** ]
[^4]: `<target>` can be one of the targets: [ **`minimal`** | **`bsp`** | **`weston`** | **`qt`** ]

