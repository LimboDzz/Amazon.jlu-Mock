<template>
  <el-carousel :interval="4000" type="card" height="400px">
    <el-carousel-item v-for="img in imgs" :key="img">
      <el-image
      style="width: 600px; height: 400px"
      :src="img"
      :fit="cover"></el-image>
    </el-carousel-item>
  </el-carousel>
</template>

<script>
import img0 from '../assets/img/0.jpg';
import img1 from '../assets/img/1.jpg';
import img2 from '../assets/img/2.jpg';
import img3 from '../assets/img/3.jpg';
import img4 from '../assets/img/4.jpg';
export default {
    name: 'Carousel',
    data(){
        return {
            imgs: [img0,img1,img2,img3,img4]
        }
    }
};
</script>

<style>
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>