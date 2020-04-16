import axios from "./customAxios";
import qs from 'qs';


const carService = {
    fetchCars: ()=> {
        return axios.get("cars");
    },
    fetchCar: (id)=> {
        return axios.get("cars/" + id);
    },
    deleteCar: (id)=> {
        return axios.delete("cars/" + id);
    },
    addCar: (car) => {

        const formParams = qs.stringify(car);
        return axios.post("/cars",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'renterId': 1
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
    fetchCarHistories: () => {
        return axios.get("cars/carHistories/" +1)
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
    addHistory: (his) => {

        const formParams = qs.stringify(his);
        return axios.post("/cars/carHistories",formParams, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'carId': 1
            }
        });
    },
};

export default carService;