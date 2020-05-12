import axios from "./customAxios";
import qs from 'qs';


const carService = {
    fetchCars: ()=> {
        return axios.get("cars");
    },
    fetchCar: (id)=> {
        return axios.get("cars/" + id);
    },
    fetchCarsByRenterId: (id)=> {
        return axios.get("cars/renter/" + id);
    },
    deleteCar: (id)=> {
        return axios.delete("cars/" + id);
    },
    deleteCarHistory: (id)=> {
        return axios.delete("cars/carHistories/" + id);
    },
    addCar: (car, renterId) => {

        const formParams = qs.stringify(car);
        return axios.post("/cars",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'renterId': renterId
            }
        });
    },
    updateCar: (car) => {

        const carId= car.id;
        const formParams = qs.stringify(car);
        return axios.patch("cars/"+carId, formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'renterId': car.renter.id
            }
        });
    },
    searchCars: (mark) => {
        return axios.get(`/cars?mark=${mark}`);
    },

    fetchTermines: (id) => {
        return axios.get("cars/" +id+ "/termines" )
    },
    fetchCarHistoriesByCar: (id) => {
        return axios.get("cars/carHistories/" +id)
    },
    updateCarHistory: (his) => {

        const hisId= his.id;
        const formParams = qs.stringify(his);
        return axios.patch("cars/carHistories/"+hisId, formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'carId': his.car.id
            }
        });
    },
    addHistory: (his, id) => {

        const formParams = qs.stringify(his);
        return axios.post("/cars/carHistories",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'carId': id
            }
        });
    },
    setCarRating: (id, rating) => {
        return axios.patch("cars/rating/"+id,{},{
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded',
                'rating': rating
            }
        })
    }
};

export default carService;