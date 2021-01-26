<template>
  <div id="container">
    <el-header class="el-header">
      旋木 图书管理系统
    </el-header>
    <router-view></router-view>
  </div>
</template>

<style>
  #container {
    width: 100%;
    height: 100%;
  }
  .el-header {
    margin: 5px auto;
    text-align: center;
    font-size: xx-large;
    font-weight: bold;
    opacity: 80%;
    background: #ecf5ff;
    border-radius: 15px;
    vertical-align: middle;
  }
</style>

<script>
export default {
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(20).fill(item)
    }
  },
  methods: {
    goBack() {
      console.log('go back');
    }
  }
};
</script>