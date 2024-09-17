<script setup lang="ts">
  import { ref } from 'vue'

  const errorMessage = ref('')
  const first = ref(0)
  const second = ref(0)
  const operator = ref('add')
  const result = ref(0)

  async function calculate() {
    try {
      errorMessage.value = '';
      const response = await fetch('http://localhost:8080/' + operator.value, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          first: first.value,
          second: second.value
        })
      }).then(response => response.json());

      result.value = response.result;
    } catch (error) {
      calculateDirect();
      errorMessage.value = 'Något gick fel: ' + error;
    }
    

  }

  function calculateDirect() {
    switch (operator.value) {
      case 'add':
        result.value = Number(first.value) + Number(second.value);
        break
      case 'subtract':
        result.value = Number(first.value) - Number(second.value);
        break
      case 'multiply':
        result.value = Number(first.value) * Number(second.value);
        break
      case 'divide':
        result.value = Number(first.value) / Number(second.value);
        break
    }
  }
</script>

<template>
  <div>
    <h1 id="header">Miniräknare</h1>

    <section>
      <input type="number" id="first" v-model="first"/>
      <select id="operator" v-model="operator">
        <option value="add">+</option>
        <option value="subtract">-</option>
        <option value="multiply">*</option>
        <option value="divide">/</option>
      </select>
      <input type="number" id="second" v-model="second"/>
      <span> = </span>
      <strong id="result">{{ result }}</strong>
    </section>

    <button id="calculate" @click="calculate">Beräkna</button>

    <section class="red" id="errorMessage" v-if="errorMessage!==''">{{ errorMessage }}</section>
  </div>
</template>

<style scoped>
body {
  font-family: Arial, sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  margin: 0;
}
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
h1:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
input {
  padding: 0.2em;
  font-size: 1.5em;
  margin: 0.2em;
}
select {
  padding: 0.2em;
  font-size: 1.5em;
  margin: 0.2em;
}
section {
  display: flex;
  align-items: center;
  margin: 1em;
  text-align: center;
}
strong {
  font-size: 1.5em;
  margin: 0.2em;
}
.red {
  color: red;
}
</style>
