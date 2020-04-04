import axios from "./customAxios"


const ingredientService = {
    fetchClients: ()=> {
        return axios.get("clients");
    },
    fetchClient: (id)=> {
        return axios.get("clients/" + id);
    },
    getAllPizzasWithIngredient: (name)=> {
        return axios.get("ingredients/" + name + "/pizzas");
    }

}

export default ingredientService;