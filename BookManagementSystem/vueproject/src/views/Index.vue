<template>
  <div id="container">
    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['0','1']" default-active="0" router>
          <el-submenu  v-for="(item,index) in $router.options.routes" v-if="item.show" :index="index+''" >
            <template slot="title"><i class="el-icon-setting"></i>{{ item.name }}</template>
            <el-menu-item-group>
              <el-menu-item v-for="(item2,index2) in item.children" index="index2" :index="item2.path"
                            :class="$route.path===item2.path?'is-active':''">{{ item2.name }}</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container >
        <el-main >
          <router-view style="height: 100%"></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Index",

}
</script>

<style scoped>
  #container {
    width: 100%;
    height: 100%;
  }
</style>