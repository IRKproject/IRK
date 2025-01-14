import { createWebHistory, createRouter } from "vue-router";
// импорт компонентов
import ListInstrument from "../../pages/instrument/listInstrument";
import AddInstrument from "../../pages/instrument/addInstrument";
import EditInstrument from "../../pages/instrument/editInstrument";

import ListParts from "../../pages/part/listParts";
import AddPart from "../../pages/part/addPart";
import EditPart from "../../pages/part/editPart";

import ListTechcard from "../../pages/techcard/listTechcard.vue";
import AddTechcard from "../../pages/techcard/addTechcard.vue";
import EditTechcard from "../../pages/techcard/editTechcard.vue";


// определяем маршруты
const routes = [
    {
        path: "/",
        redirect: "/instruments"
    },
    {
        path: "/instruments",
        name: "instrument",
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
    },
    {
        path: "/parts",
        name: "part",
        component: ListParts,
        meta: {
            title: "ИРК-Список инструментов"
        }
    },
    {
        path: "/parts/add",
        name: "addpart",
        component: AddPart,
        meta: {
            title: "ИРК-Добавить инструмент"
        }
    },
    {
        path: "/parts/edit/:id",
        name: "editpart",
        component: EditPart,
        meta: {
            title: "ИРК-Редактировать часть"
        }
    },
    {
        path: "/techcards",
        name: "techcard",
        component: ListTechcard,
        meta: {
            title: "ИРК-Список техкарт"
        }
    },
    {
        path: "/techcards/add",
        name: "addtechcard",
        component: AddTechcard,
        meta: {
            title: "ИРК-Добавить техкарту"
        }
    },
    {
        path: "/techcards/edit/:id",
        name: "edittechcard",
        component: EditTechcard,
        meta: {
            title: "ИРК-Редактировать техкарту"
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