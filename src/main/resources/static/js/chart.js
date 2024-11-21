// Add figures
let instock= $("#instock");
$.ajax({
    url: '/api/product/instock',
    method: 'GET',
    success: function (data) {
        instock.text(data + " products");
    }
})

let earningAnnual= $("#earning-annual");
let earningMonthly= $("#earning-monthly");
$.ajax({
    url: '/api/order/earnings',
    method: 'GET',
    success: function (data) {
        earningAnnual.text("$ " + data.earningYearly);
        earningMonthly.text("$ " +data.earningMonthly);
    }
})
// Create chart
const ac = document.getElementById('areaChart').getContext('2d');
const dc = document.getElementById('donutChart').getContext('2d');

const ac_data = {
labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
datasets: [{
    label: 'Earning',
    data: [30, 50, 40, 60, 70, 50, 90],
    backgroundColor: 'rgba(162,169,253,0.1)',
    borderColor: '#0d6efd',
    borderWidth: 4,
    tension: 0.3,
    fill: true
}]
};

const ac_config = {
type: 'line',
data: ac_data,
options: {
    responsive: true,
    interaction: {
        intersect: false,
        mode: 'index'
    },
    responsive: true,
    scales: {
        x: {
            grid: {
                drawOnChartArea: false
            }
        },
        y: {
            grid: {
                drawOnChartArea: false
            },
            ticks: {
                stepSize: 20,
                min: 0
            },
            beginAtZero: true
        }
    },
    plugins: {
        tooltip: {
            backgroundColor: '#fff',
            titleColor: 'rgba(0 , 0, 0, 0.5)',
            bodyColor: 'rgba(0 , 0, 0, 0.4)',
            padding: 10,
            displayColors: false
        },
        legend: {
            display: false
        }
    },
    animation: {
        duration: 2500,
        easing: 'easeInOutBack'
    }
},
};

const dc_data = {
labels: ['Successed', 'Failed', 'Pending'],
datasets: [{
    label: 'Order',
    data: [60, 40, 20],
    backgroundColor: ['rgb(55, 183, 195)', 'rgb(7, 25, 82)', '#0d6efd'],
    borderWidth: 2
}]
};

const dc_config = {
type: 'doughnut',
data: dc_data,
options: {
    layout: {
        padding: {
            top: 10,
            left: 20
        }
    },
    responsive: true,
    plugins: {
        tooltip: {
            enabled: true,
            backgroundColor: '#fff',
            titleColor: 'rgba(0 , 0, 0, 0.5)',
            bodyColor: 'rgba(0 , 0, 0, 0.4)',
            displayColors: false
        },
        legend: {
            position: 'bottom',
            labels: {
                color: 'rgba(0 , 0, 0, 0.5)',
                usePointStyle: true,
                pointStyle: 'circle',
                pointRadius: 10
            }
        }
    },
    cutout: '75%',
    animation: {
        duration: 2500,
        easing: 'easeInOutBack'
    },
    elements: {
        arc: {
            borderWidth: 0,
            borderColor: 'rgba(0, 0, 0, 0)',
            hoverOffset: 25,
        }
    }
}
};
new Chart(ac, ac_config);
new Chart(dc, dc_config);