using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace dotNet_Client
{
    public partial class Convert : Form
    {
        public Convert()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ServiceReference1.BankServiceClient proxy = new ServiceReference1.BankServiceClient();
            double amount = Double.Parse(amountTB.Text);
            double result = proxy.Convert(amount);
            resultTB.Text = "" + result;
        }

    }
}
