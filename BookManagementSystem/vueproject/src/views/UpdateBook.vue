<template>
  <div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"  class="demo-ruleForm">
      <el-form-item label="图书编号" prop="id">
        <el-input v-model="ruleForm.id" readonly></el-input>
      </el-form-item>
      <el-form-item label="图书名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>
      <el-form-item label="书籍类型" prop="type">
        <el-input v-model="ruleForm.type"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publish">
        <el-input v-model="ruleForm.publish"></el-input>
      </el-form-item>

      <el-form-item label="出版时间" required>
        <el-col :span="11">
          <el-form-item prop="time">
            <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.time"
                            style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="价格" prop="price">
        <el-input v-model="ruleForm.price"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">更新图书</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "AddBook",
  data() {
    return {
      ruleForm: {
        id:'',
        name: '',
        author: '',
        publish: '',
        time: '',
        type: '',
        price: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入书籍名称', trigger: 'blur' },
          { min: 1, max: 25, message: '书名长度过短或过长', trigger: 'blur' }
        ],
        author: [
          { required: true, message: '请输入书籍作者', trigger: 'change' }
        ],
        time: [
          { type: 'string', required: true, message: '请选择图书出版日期', trigger: 'change' }
        ],
        publish : [
          { required: true, message: '请输入出版社信息', trigger: 'change' }
        ],
        type: [
          { required: false, message: '请输入图书类型', trigger: 'change' }
        ],
        price: [
          { required: true, message: '请填写书籍价格', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/book/update',_this.ruleForm).then(function (res) {
            if (res.data === "success") {
              _this.$message({
                showClose: true,
                message: '恭喜你，更新图书信息成功',
                type: 'success'
              });
            }
            _this.$router.push('/')
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/book/findById/'+_this.$route.query.id).then(function (res) {
      _this.ruleForm = res.data
    })
  }
}
</script>

<style scoped>
.demo-ruleForm {
  margin: 15px auto;
  max-width: 60%;
}
</style>