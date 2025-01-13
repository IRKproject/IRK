import { createWebHistory, createRouter } from "vue-router";
// импорт компонентов
import ListInstrument from "./components/instrument/listInstrument";
import AddInstrument from "./components/instrument/addInstrument";
import EditInstrument from "./components/instrument/editInstrument";

// определяем маршруты
const routes = [
    {
        path: "/instruments",
        name: "instrument",
        alias: "/instrument",
        component: ListInstrument,
        meta: {
            title: "ИРК-Список инструментов"
        }
    },
    {
        path: "/instruments/add",
        name: "addinstrument",
        component: AddInstrument,
        meta: {
            title: "ИРК-Добавить инструмент"
        }
    },
    {
        path: "/instruments/edit/:id",
        name: "editinstrument",
        component: EditInstrument,
        meta: {
            title: "ИРК-Редактировать инструмент"
        }
    }
];

const router = createRouter({
    history: createWebHistory(), // указываем, что будет создаваться история посещений веб-страниц
    routes, // подключаем маршрутизацию
});

// указание заголовка компонентам (тега title), заголовки определены в meta
router.beforeEach((to, from, next) => {
    // для тех маршрутов, для которых не определены компоненты, подключается только App.vue
    // поэтому устанавливаем заголовком по умолчанию название "Главная страница"
    document.title = to.meta.title || 'Главная страница';
    next();
});

export default router;