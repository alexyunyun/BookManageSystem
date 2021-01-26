<template>
  <div>
    <el-table
        :data="tableData"
        style="width: 100%;">
      <el-table-column
          label="图书号"
          width="80">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="书名"
          width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>书名: {{ scope.row.name }}</p>
            <p>类型: {{ scope.row.type }}</p>
            <p>出版时间: {{ scope.row.time }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column
          label="出版社"
          width="180">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="图书类型"
          width="180">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.publish }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="价格"
          width="180">
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.price }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
          </el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        layout="prev, pager, next"
        :page-size="8"
        :total="total"
        class="m-page"
        @current-change="page">
    </el-pagination>
  </div>

</template>

<script>
import router from "@/router";
import Vue from "vue";

export default {
  data() {
    return {
      total: null,
      tableData: null
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);

      this.$router.push({
        path: '/update',
        query: {
          id: row.id
        }
      })

    },
    handleDelete(index, row) {
      const _this = this
      console.log(index, row);
      axios.get('http://localhost:8181/book/delete/'+row.id).then(function (res) {
        _this.$message({
          showClose: true,
          message: '图书删除成功',
          type: 'success'
        });
        window.location.reload()
      })
    },
    page(currentPage){
      const that=this
      axios.get('http://localhost:8181/book/findAll/'+currentPage+'/8').then(function (res) {
        that.total = res.data.totalElements
        that.tableData = res.data.content
        console.log(res)
      })
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/book/findAll/1/8').then(function (res) {
      _this.total = res.data.totalElements
      _this.tableData = res.data.content
      console.log(res)
      console.log(_this.total)
    })
  },
}
</script>

<style scoped>
  .m-page {
    margin: 10px auto;
  }
</style>