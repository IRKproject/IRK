<template>
    <div>
      <h1>Login</h1>
      <form @submit.prevent="login">
        <div>
          <label for="login">Login:</label>
          <input type="text" id="login" v-model="form.login" />
        </div>
        <div>
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="form.password" />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: 'LoginPage', // Используем многословное имя
    data() {
      return {
        form: {
          login: '',
          password: ''
        }
      };
    },
    methods: {
  async login() {
    try {
      const formData = new URLSearchParams();
      formData.append('username', this.form.login);
      formData.append('password', this.form.password);

      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: formData,
      });

      if (response.ok) {
        const data = await response.json();
        localStorage.setItem('token', data.token);
        this.$router.push('/instruments');
      } else {
        alert('Login failed');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  }
}
  };
  </script>