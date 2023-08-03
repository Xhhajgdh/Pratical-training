<template>
  <div class="aside">
    <el-menu
      :uniqueOpened="true"
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff" router
      active-text-color="#409EFF">
      <el-sub-menu index="1">
        <template #title>
          <i class="el-icon-location"></i>
          <span>管理员功能</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/adminLayout/customer">用户管理</el-menu-item>
          <el-menu-item index="/adminLayout/driver">司机管理</el-menu-item>
          <el-menu-item index="/adminLayout/car">车辆管理</el-menu-item>
          <el-menu-item index="/adminLayout/auditOrder">待审核订单</el-menu-item>
          <el-menu-item index="/adminLayout/allOrder">全部订单</el-menu-item>
<!--          <el-menu-item index="/adminLayout/auditOrder">运费预算</el-menu-item>-->
        </el-menu-item-group>
      </el-sub-menu>

    </el-menu>
  </div>
</template>

<script>
  export default {
    name: 'Aside',
    data() {
      return {
        active: this.$route.path
      }
    },
    methods: {}
  }
</script>

<style scoped>
  .aside {
    width: 202px;
    height: calc(100vh - 50px);
    border-right: 1px solid #ccc;
    background-color: #333744;
  }
</style>