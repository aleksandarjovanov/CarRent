import axios from "./customAxios"


const ingredientService = {
    fetchClients: ()=> {
        return axios.get("clients");
    },
    fetchClient: (id)=> {
        return axios.get("clients/" + id);
    },
    deleteClient: (id)=> {
        return axios.delete("clients/" + id);
    },
    getAllPizzasWithIngredient: (name)=> {
        return axios.get("ingredients/" + name + "/pizzas");
    }

}

export default ingredientService;