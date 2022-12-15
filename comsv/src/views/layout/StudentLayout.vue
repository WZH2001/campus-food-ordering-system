<template>
  <div>
    <h1>这是学生layout</h1>
    <div style="flex: 1;padding: 5px">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "StudentLayout"
}
</script>