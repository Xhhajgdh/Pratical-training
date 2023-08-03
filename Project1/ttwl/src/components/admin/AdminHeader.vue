<template>
  <div class="head">
    <div style="width: 150px;">
      <span style="margin-left: 60px;font-size: 20px">物流系统</span>
    </div>
    <div style="flex: 1"></div>
    <div style="width: 200px;">
      <div style="margin-right: 50px;">
        <el-dropdown>
        <span class="el-dropdown-link">
          <span v-if="null != user" style="color: white">管理员：{{user.admin_name}}</span>
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item @click="loginout">注销</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'AdminHeader',
    data() {
      return {
        user: JSON.parse(sessionStorage.getItem("admin"))
      }
    },
    methods:{
      loginout(){
        sessionStorage.clear()
        this.$router.push('/login')
      }
    }
  }
</script>

<style scoped>
  .head {
    width: 100%;
    height: 60px;
    line-height: 60px;
    background-color: #373D41;
    color: white;
    display: flex;
  }

  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }

  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>