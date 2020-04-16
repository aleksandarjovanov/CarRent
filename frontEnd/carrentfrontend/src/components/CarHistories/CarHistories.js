import React, {useState, useEffect} from 'react';
import {Route, useHistory} from "react-router-dom"
import carService from "../API/axiosCarService";
import ListHistories from "./ListHistories";
import EditHistory from "./EditHistory";
import AddHistory from "./AddHistory";

const CarHistories = ({match}) => {

    useEffect(() =>{
        loadHistories();
    },[]);

    const [histories, setHistories] = useState([]);
    const [singleHistory, setSingleHistory] = useState({});


    const history = useHistory();


    const loadHistories = () => {
        carService.fetchCarHistories().then(response=>{
            setHistories(response.data);
        })
    };

    const deleteHistory = (id) => {
        carService.deleteCarHistory(id).then(() => {

            const hisReduced = histories.filter((r) => {
                return r.id !== id;
            });
            setHistories(hisReduced);
            history.push("/carHistories/list");
        })
    };

    const createHistory = (c) => {
        carService.addHistory(c).then((response)=>{
            const tmpc = response.data;

            const newCarsRef = [...histories, tmpc];
            setHistories(newCarsRef);
            history.push("/carHistories/list");

        });
    };

    const updateHistory = ((editedHistory) => {
        carService.updateCarHistory(editedHistory).then((response)=>{

            const newHistory = response.data;

            const newHisRef = histories.map((item)=>{

                if (item.id===newHistory.id) {
                    return newHistory;
                }
                return item;
            });

            setHistories(newHisRef);
            history.push("/carHistories/list");
        });
    });

    const costumeTest = (id) => {
        histories.map((item) => {
            if(item.id === id)
                setSingleHistory(item);
        });

        history.push(`/carHistories/edit/${id}`);
    };


    return (
        <div>
            <Route path={`${match.path}/list`} exact render={() => <ListHistories histories={histories} costumeTest={costumeTest}/>}/>
            <Route path={"/carHistories/edit/:id"} exact render={(props) => <EditHistory {...props} onSubmit={updateHistory} singleHistory={singleHistory}/>}/>
            <Route path={"/carHistories/add"} exact render={(props) => <AddHistory {...props} onCreate={createHistory}/>} />
        </div>
    );
};

export default CarHistories;